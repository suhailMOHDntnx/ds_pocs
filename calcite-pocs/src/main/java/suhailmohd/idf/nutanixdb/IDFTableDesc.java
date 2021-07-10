package suhailmohd.idf.nutanixdb;

import com.nutanix.insights.ifc.InsightsInterfaceProto.MetricType;
import java.util.ArrayList;
import org.json.JSONObject;
import java.lang.System;

public class IDFTableDesc {

    public static class FieldDesc {
        public String name;
        public String type;
    
        FieldDesc(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }

    public  ArrayList<FieldDesc> fieldDescs;
    public String tableName;

    IDFTableDesc(ArrayList<MetricType> metricTypes, String tableName) {
        this.tableName = tableName;
        this.fieldDescs = constructFieldDescs(metricTypes);
    }

    private static ArrayList<FieldDesc> constructFieldDescs(ArrayList<MetricType> metricTypes) {
        ArrayList<FieldDesc> descs = new ArrayList<FieldDesc>();

        for (MetricType t: metricTypes) {
            String metadataString = t.getUserMetadata();
            System.err.println(t.getMetricName());
            System.err.println(metadataString);

            if (metadataString == "") {
                System.err.println("Ignoring metric: " + t.getMetricName());
                continue;
            }
            JSONObject metadata = new JSONObject(metadataString);

            // TODO: Add error handling code here.
            // Case metadata could not be created
            // Case data_type does not exist
            // Case data_type is not string
            String dataType = (String) metadata.get("data_type");

            descs.add(new IDFTableDesc.FieldDesc(t.getMetricName(), dataType));
        }

        return descs;
    }
}