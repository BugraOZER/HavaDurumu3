/*  package com.bugra.myapplication;

public class denemeler {



  public void Newcardlist() {
        apilink=city_url.get(mposition);
        for(int m=0; m<city_url.size();m++){
            String url =apilink;

            JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONObject o_main = response.getJSONObject( "main" );
                        JSONArray JA = response.getJSONArray( "weather" );
                        for(int c=0;c<o_main.length();c++) {
                            JSONObject JO = JA.getJSONObject( c );
                            desc = JO.getString( "description" );
                            icon = JO.getString( "icon" );
                            String temp = String.valueOf( o_main.getDouble( "temp" ) );
                            city = response.getString( "name" );
                            double temp1 = Double.parseDouble( temp );
                            double centi = (temp1 - 32) / 1.8000;
                            centi = Math.round( centi );
                            a = (int) centi;
                            tempreture= a+"°C";
                        /*String url="https://openweathermap.org/img/w/"+icon;
                        Picasso.with(this).load(url).into(imageView2);*/




         /*               }
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
            RequestQueue mqueue = Volley.newRequestQueue(this);
            mqueue.add(jor1);





        }xcardlist.add( new Card(city,tempreture,desc ));
    }

}
*/