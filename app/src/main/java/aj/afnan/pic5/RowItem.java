package aj.afnan.pic5;

/**
 * Created by afnan on 6/20/16.
 */
public class RowItem {
    private String Option_Name;
    private int Icon_id;
    private int Move_id;

    public RowItem (String Option_Name , int Icon_id ,int Move_id ){


        this.Option_Name=Option_Name;
        this.Icon_id=Icon_id;
        this.Move_id=Move_id;

    }

    public  String getOption_Name(){return Option_Name;}
    public void setOption_Name(String Option_Name){this.Option_Name=Option_Name;}
    public int getIcon_id(){return Icon_id;}
    public void setIcon_id(int Icon_id){this.Icon_id=Icon_id;}
    public int getMove_id(){return Move_id;}
    public void setMove_id(int Move_id){this.Move_id=Move_id;}

}
