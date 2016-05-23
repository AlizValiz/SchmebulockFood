package com.herprogramacion.restaurantericoparico.modelo;

/**
 * Created by Alejandro D on 19/05/2016.
 */
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class JSONParser extends AsyncTask<String, Void, String> {

    private Context context;

    public JSONParser(Context context) {
        this.context = context;
    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... arg0) {
        String mesaNo = arg0[0];
        String date = arg0[1];
        String plat1 = arg0[2];
        String plat1price = arg0[3];
        String plat2 = arg0[4];
        String plat2price = arg0[5];
        String plat3 = arg0[6];
        String plat3price = arg0[7];
        String bebida = arg0[8];
        String bebidaprice = arg0[9];

        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try {
            data = "?mesaNo=" + URLEncoder.encode(mesaNo, "UTF-8");
            data += "&date=" + URLEncoder.encode(date, "UTF-8");
            data += "&plat1=" + URLEncoder.encode(plat1, "UTF-8");
            data += "&plat1price=" + URLEncoder.encode(plat1price, "UTF-8");
            data += "&plat2=" + URLEncoder.encode(plat2, "UTF-8");
            data += "&plat2price=" + URLEncoder.encode(plat2price, "UTF-8");
            data += "&plat3=" + URLEncoder.encode(plat3, "UTF-8");
            data += "&plat3price=" + URLEncoder.encode(plat3price, "UTF-8");
            data += "&bebida=" + URLEncoder.encode(bebida, "UTF-8");
            data += "&bebidaprice=" + URLEncoder.encode(bebidaprice, "UTF-8");

            link = "http://192.168.0.12/phpConector/db_Connect_Insert.php" + data;
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
            return result;
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        String jsonStr = result;
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String query_result = jsonObj.getString("query_result");
                if (query_result.equals("SUCCESS")) {
                    Toast.makeText(context, "Orden correctamente realizada.", Toast.LENGTH_SHORT).show();
                } else if (query_result.equals("FAILURE")) {
                    Toast.makeText(context, "Los datos no pudieron ser procesados.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "No hay conexion con Servidor.", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context, "JSON incompleto.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "No se logro obtener datos del JSON.", Toast.LENGTH_SHORT).show();
        }
    }
}
