package com.martintecno.llamada.ui.home;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.net.URI;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<String> MensajeM;
    private Context context;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        context = getApplication().getApplicationContext();
    }


    public LiveData<String> getCartelM(){
        if(MensajeM == null){
            MensajeM = new MutableLiveData<String>();
        }
        return MensajeM;
    }



    public void HacerLlamada(String numeroTelefono) {


        if(numeroTelefono.length() > 9){

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+numeroTelefono));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else{
            MensajeM.setValue("Numero de telefono incorrecto 10 numeros minimo");
        }


    }







}