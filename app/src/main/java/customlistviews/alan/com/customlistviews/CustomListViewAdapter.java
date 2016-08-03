package customlistviews.alan.com.customlistviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Alan on 08/06/2016.
 */
public class CustomListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<HashMap<String, String>> books;
    private static LayoutInflater inflater = null;

    public CustomListViewAdapter(Context context, ArrayList<HashMap<String, String>> data){

        mContext = context;
        books = data;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        //gets access to the XML file
        if(convertView == null){
           view = inflater.inflate(R.layout.list_row, null);

            //assigns the XML variables to java variables allowing them to be manipulated
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView author = (TextView) view.findViewById(R.id.author);
            TextView pages = (TextView) view.findViewById(R.id.pages);
            ImageView image = (ImageView) view.findViewById(R.id.imageView);

            HashMap<String, String> mBook = new HashMap<>();

            mBook = books.get(position);

            //gets the value for title from the hashmap and assigns it to the XML variable
            title.setText(mBook.get("title"));
            author.setText(mBook.get("author"));
            pages.setText(mBook.get("pages"));
            image.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.ic_launcher));
        }

        return view;
    }
}
