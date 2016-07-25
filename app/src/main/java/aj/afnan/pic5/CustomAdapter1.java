package aj.afnan.pic5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
/**
 * Created by afnan on 6/21/16.
 */
public class CustomAdapter1 extends BaseAdapter {
        Context context ;
        List<RowItem> rowItems;

    CustomAdapter1(Context context, List<RowItem> rowItems){
            this.context = context;
            this.rowItems = rowItems;
        }

        @Override
        public int getCount(){return rowItems.size();}

        @Override
        public Object getItem(int posotion){return  rowItems.get(posotion);}

        @Override
        public long getItemId(int postion){return rowItems.indexOf(getItem(postion));}

        private class ViewHolder{
            ImageView Icon_id;
            ImageView Move_id;
            TextView Option_Name;
        }

        @Override
        public View getView (int postion , View convertView , ViewGroup parent){
            ViewHolder holder = null;

            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView == null){
                convertView=mInflater.inflate(R.layout.single_row, null);
                holder=new ViewHolder();

                holder.Option_Name=(TextView) convertView.findViewById(R.id.textViewRow);
                holder.Icon_id=(ImageView) convertView.findViewById(R.id.imageViewIcon);
                holder.Move_id=(ImageView) convertView.findViewById(R.id.imageViewMove);

                RowItem row_pos = rowItems.get(postion);
                holder.Option_Name.setText(row_pos.getOption_Name());
                holder.Icon_id.setImageResource(row_pos.getIcon_id());
                holder.Move_id.setImageResource(row_pos.getMove_id());


                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            return convertView;
        }

    }


