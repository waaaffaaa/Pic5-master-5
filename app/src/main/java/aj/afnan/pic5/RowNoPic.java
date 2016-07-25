package aj.afnan.pic5;

/**
 * Created by afnan on 7/18/16.
 */
public class RowNoPic {

        private String Option_Name;
        private int Move_id;

        public RowNoPic (String Option_Name ,int Move_id ){


            this.Option_Name=Option_Name;
            this.Move_id=Move_id;

        }

        public  String getOption_Name(){return Option_Name;}
        public void setOption_Name(String Option_Name){this.Option_Name=Option_Name;}
        public int getMove_id(){return Move_id;}
        public void setMove_id(int Move_id){this.Move_id=Move_id;}

    }
