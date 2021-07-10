package suhailmohd.idf.nutanixdb;

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
import com.nutanix.insights.insights_interface.InsightsInterface;
import com.nutanix.insights.ifc.InsightsInterfaceProto.GetMetricTypesArg;
import com.nutanix.insights.ifc.InsightsInterfaceProto.GetEntitiesWithMetricsArg;
import com.nutanix.insights.ifc.InsightsInterfaceProto.GetEntitiesWithMetricsRet;
import com.nutanix.insights.ifc.InsightsInterfaceProto.GetMetricTypesRet;
import com.nutanix.insights.ifc.InsightsInterfaceProto.MetricType;
import com.nutanix.insights.exception.InsightsInterfaceException;
import java.util.List;
import java.util.HashMap;

public class IDF {
    InsightsInterface ifc;

    public IDF() {
        this.ifc = new InsightsInterface();
    }

    public ArrayList<IDFTableDesc> ListTables() throws InsightsInterfaceException {
        ArrayList<IDFTableDesc> tableDescs = new ArrayList<IDFTableDesc>();
        
        GetMetricTypesArg.Builder builder = GetMetricTypesArg.newBuilder();
        GetMetricTypesRet metricTypesRet = ifc.getMetricTypes(builder.build());

        // Group atrributes by entity_type name
        List<MetricType> metrics = metricTypesRet.getMetricTypeListList();

        HashMap<String, ArrayList<MetricType>> groups = new HashMap<String, ArrayList<MetricType>>();
        for(MetricType metric: metrics) {
            if (!metric.getIsAttribute()) {
                continue;
            }

            if (metric.getContainsSerialisedProto()) {
                continue;
            }
            
            ArrayList<MetricType> group = groups.get(metric.getEntityTypeName());

            if (group == null) {
                group = new ArrayList<MetricType>();
                groups.put(metric.getEntityTypeName(), group);
            }

            group.add(metric);
        }

        // Construct table for each group
        groups.forEach(
            (k, v) -> tableDescs.add(new IDFTableDesc(v, k))
        );

        return tableDescs;
    }

    public GetEntitiesWithMetricsRet QueryTable(GetEntitiesWithMetricsArg arg) throws InsightsInterfaceException {
        return ifc.getEntitiesWithMetrics(arg);
    }
}