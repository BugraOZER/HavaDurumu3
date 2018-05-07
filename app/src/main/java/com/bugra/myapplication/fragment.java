package com.bugra.myapplication;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.VISIBLE;
import static com.bugra.myapplication.MainActivity.*;

public class fragment extends AppCompatActivity {
    MaterialSearchView searchView;
    ListView lstview;
    int mposition,x;
    String tempreture;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static ArrayList<Card> xcardlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Material Search");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        lstview = (ListView) findViewById(R.id.lstview);
        ArrayAdapter adapter = new ArrayAdapter(fragment.this, android.R.layout.simple_list_item_1, msehirler);
        searchView = findViewById(R.id.search_view);

        xcardlist.add( new Card( city,desc,a+"°C" ) );
        recyclerView = findViewById( R.id.rView );
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager( this );
        mAdapter = new CardAdapter( xcardlist );
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setAdapter( mAdapter );




        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener(){
            @Override
            public void onSearchViewShown() {
                lstview.setVisibility(lstview.VISIBLE);
                recyclerView.setVisibility( recyclerView.INVISIBLE );
            }
            @Override
            public void onSearchViewClosed() {

                lstview = (ListView) findViewById(R.id.lstview);

                ArrayAdapter adapter = new ArrayAdapter(fragment.this, android.R.layout.simple_list_item_1, msehirler);
                lstview.setAdapter(adapter);


            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                if (newText != null && !newText.isEmpty()) {

                    List<String> lstfound = new ArrayList<>();

                    for (String item : msehirler) {

                        if (item.contains(newText))

                            lstfound.add(item);

                            ArrayAdapter adapter = new ArrayAdapter(fragment.this, android.R.layout.simple_list_item_1, lstfound);
                            lstview.setAdapter(adapter);
                        }
                    }else {
                            ArrayAdapter adapter = new ArrayAdapter(fragment.this, android.R.layout.simple_list_item_1,msehirler);
                            lstview.setAdapter(adapter);


                        }//else

                        return true;
                    }//if

                });

       lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l){

                position=x;
                Intent intent = new Intent(getApplicationContext(),fragment.class);
                lstview.getItemAtPosition( x );

                Toast.makeText(getApplicationContext(),msehirid.get(mposition),Toast.LENGTH_LONG).show();
                apilink=mcity_url.get(x);
                hava_durumu();
                mAdapter.notifyDataSetChanged();
                startActivity( intent );
            }
        });





        }




    public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.menu_item, menu);
            MenuItem item = menu.findItem(R.id.action_search);
            searchView.setMenuItem(item);
            return true;



        }

    public void hava_durumu() {

        apilink=mcity_url.get(x);

        String url =apilink;
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject o_main = response.getJSONObject( "main" );

                        JSONArray JA = response.getJSONArray( "weather" );
                        JSONObject JO = JA.getJSONObject( 0 );
                        desc = JO.getString( "description" );
                        icon = JO.getString( "icon" );
                        String temp = String.valueOf( o_main.getDouble( "temp" ) );
                        String humidity = String.valueOf( o_main.getDouble( "humidity" ) );
                        String temp_min = String.valueOf( o_main.getDouble( "temp_min" ) );
                        String temp_max = String.valueOf( o_main.getDouble( "temp_max" ) );
                        if (icon.equals( "01d" )) imageView2.setImageResource( R.drawable.i01d );
                        if (icon.equals( "01n" )) imageView2.setImageResource( R.drawable.i01n );
                        if (icon.equals( "02d" )) imageView2.setImageResource( R.drawable.i02d );
                        if (icon.equals( "02n" )) imageView2.setImageResource( R.drawable.i02n );
                        if (icon.equals( "03d" )) imageView2.setImageResource( R.drawable.i03d );
                        if (icon.equals( "03n" )) imageView2.setImageResource( R.drawable.i03n );
                        if (icon.equals( "04d" )) imageView2.setImageResource( R.drawable.i04d );
                        if (icon.equals( "04n" )) imageView2.setImageResource( R.drawable.i04n );
                        if (icon.equals( "09d" )) imageView2.setImageResource( R.drawable.i09d );
                        if (icon.equals( "09n" )) imageView2.setImageResource( R.drawable.i09n );
                        if (icon.equals( "10d" )) imageView2.setImageResource( R.drawable.i10d );
                        if (icon.equals( "10n" )) imageView2.setImageResource( R.drawable.i10n );
                        if (icon.equals( "11d" )) imageView2.setImageResource( R.drawable.i11d );
                        if (icon.equals( "11n" )) imageView2.setImageResource( R.drawable.i11n );
                        if (icon.equals( "13d" )) imageView2.setImageResource( R.drawable.i13d );
                        if (icon.equals( "13n" )) imageView2.setImageResource( R.drawable.i13n );
                        if (icon.equals( "50d" )) imageView2.setImageResource( R.drawable.i50d );
                        if (icon.equals( "50n" )) imageView2.setImageResource( R.drawable.i50n );

                        city = response.getString( "name" );
                        toolbar.setTitle( city );
                        xdescription.setText( desc );
                        xhumidity.setText( "Nem: %" + humidity );

                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat( "EEEE-MM-dd" );
                        String formatted_date = sdf.format( calendar.getTime() );
                        xdate.setText( formatted_date );

                        double temp1 = Double.parseDouble( temp );
                        double centi = (temp1 - 32) / 1.8000;
                        centi = Math.round( centi );
                        a = (int) centi;
                        xtemp.setText( a + "°C" );

                        double temp_min1 = Double.parseDouble( temp_min );
                        double centi_min = (temp_min1 - 32) / 1.8000;
                        centi_min = Math.round( centi_min );
                        int a_min = (int) centi_min;
                        xtemp_min.setText( "En Düşük Sıcaklık:" + a_min + "°C" );

                        double temp_max1 = Double.parseDouble( temp_max );
                        double centi_max = (temp_max1 - 32) / 1.8000;
                        centi_max = Math.round( centi_max );
                        int a_max = (int) centi_max;
                        xtemp_max.setText( "En Yüksek Sıcaklık:" + a_max + "°C" );

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                }
        );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);

    }


    }