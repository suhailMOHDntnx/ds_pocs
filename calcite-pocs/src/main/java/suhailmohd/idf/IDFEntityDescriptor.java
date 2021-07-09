package suhailmohd.idf;

public class IDFEntityDescriptor {
    String[] rowDescs;
    String name;

    IDFEntityDescriptor(String[] rowDescs, String name) {
        this.name = name;
        this.rowDescs = rowDescs;
    }
}
