package customlistviews.alan.com.customlistviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomListViewAdapter customListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final String[] bookTitles = new String[]{
                "Android Application Development",
                "The Hunger Games",
                "Harry Potter and the Order of the Phoenix",
                "To Kill a Mockingbird",
                "Pride and Prejudice",
                "Twilight",
                "The Chronicles of Narnia",
                "Animal Farm",
                "Gone with the Wind",
                "The Book Thief"
        };

        final String[] bookPages = new String[]{
                "200 pages",
                "300 pages",
                "450 pages",
                "1200 pages",
                "550 pages",
                "250 pages",
                "720 pages",
                "675 pages",
                "800 pages",
                "935 pages"
        };

        final String[] bookAuthors = new String[]{
                "Android ATC Team",
                "Suzanne Collins",
                "J.K. Rowling",
                "Harper Lee",
                "Jane Austen",
                "Stephenie Meyer",
                "C.S. Lewis",
                "George Orwell",
                "Margaret Mitchell",
                "Markus Zusak",
        };

        ArrayList<HashMap<String, String>> authorList = new ArrayList<>();

        for (int i = 0; i<10; i++){

            HashMap<String, String> data  = new HashMap<>();
            data.put("title", bookTitles[i]);
            data.put("pages", bookPages[i]);
            data.put("author", bookAuthors[i]);

            authorList.add(data);
        }

        listView = (ListView)findViewById(R.id.list);

        //Setup adapter
        customListViewAdapter = new CustomListViewAdapter(getApplicationContext(), authorList);
        listView.setAdapter(customListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int myPosition = position;

                String itemClickedId = listView.getItemAtPosition(myPosition).toString();

                Toast.makeText(getApplicationContext(),"Id Clicked: "+itemClickedId, Toast.LENGTH_LONG).show();
            }
        });
    }
}
