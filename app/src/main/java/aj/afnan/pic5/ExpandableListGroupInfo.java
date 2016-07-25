package aj.afnan.pic5;

import java.util.ArrayList;

public class ExpandableListGroupInfo  {

    private String name;
    private ArrayList<ExpandableListChildInfo> list = new ArrayList<ExpandableListChildInfo>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ExpandableListChildInfo> getProductList() {
        return list;
    }

    public void setProductList(ArrayList<ExpandableListChildInfo> productList) {
        this.list = productList;
    }

}
