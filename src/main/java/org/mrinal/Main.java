package org.mrinal;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//
//        String url = "https://jsonplaceholder.typicode.com/todos/1";
//
//        Request req = new Request.Builder()
//                .url(url)
//                .build();
//
//        try(Response res = client.newCall(req).execute()) {
//
//            if(!res.isSuccessful()) {
//                System.out.println("Something went wrong");
//
//            }
//            System.out.println(res.body().string());
//        }catch (IOException ex) {
//            ex.printStackTrace();
//        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TodoService service = retrofit.create(TodoService.class);
        Todo t = service.getTodoByID("1").execute().body();
        System.out.println("Todo object is downloaded and it is: "+t.toString());

    }
}