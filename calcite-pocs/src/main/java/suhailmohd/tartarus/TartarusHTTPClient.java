package suhailmohd.tartarus;

import java.util.ArrayList;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.IOException;
import java.io.StringReader;
import org.json.JSONArray;
import org.json.JSONObject;


class TartarusTableDescription {
    String[] rowDescs;
    String name;

    TartarusTableDescription(String[] rowDescs, String name) {
        this.name = name;
        this.rowDescs = rowDescs;
    }
}

class TartarusHTTPClient {
    String ip;
    String port;

    TartarusHTTPClient(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    ArrayList<TartarusTableDescription> ListTables() throws IOException {
        ArrayList<TartarusTableDescription> tableDescs = new ArrayList<TartarusTableDescription>();

        String urlString = "http://" + ip + ":" + port + "/list";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(urlString);

        HttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        JSONArray tableDescsJSON = new JSONArray(result);
        for (Object obj : tableDescsJSON) {
            JSONObject jobj = (JSONObject) obj;

            String name = (String) jobj.get("name");

            JSONArray rowTypesJ = (JSONArray) jobj.get("row_types");
            String[] rowDescs = new String[rowTypesJ.length()];
            for (int i = 0; i < rowTypesJ.length(); i++) {
                rowDescs[i] = (String) rowTypesJ.get(i);
            }

            tableDescs.add(new TartarusTableDescription(rowDescs, name));
        }

        return tableDescs;
    }

    ArrayList<Object[]> QueryTable(TartarusTableDescription tableDesc) throws IOException {
        ArrayList<Object[]> rows = new ArrayList<Object[]>();

        String urlString = "http://" + ip + ":" + port + "/query?table=" + tableDesc.name;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(urlString);

        HttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        JSONArray rowsJSON = new JSONArray(result);
        for (Object obj : rowsJSON) {
            JSONArray rowJSON = (JSONArray) obj;

            Object[] row = new Object[rowJSON.length()];

            for (int i=0;i<rowJSON.length();i++) {
                row[i] = rowJSON.get(i);
            }

            rows.add(row);
        }

        return rows;
    }
}