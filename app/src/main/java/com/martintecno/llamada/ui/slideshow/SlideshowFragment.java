package com.martintecno.llamada.ui.slideshow;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.martintecno.llamada.Carteles;
import com.martintecno.llamada.MainActivity;
import com.martintecno.llamada.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        binding.BTNSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Carteles.CartelSalir( aca va la activity );
               // Carteles.CartelSalir( getActivity());// esto cierra la activity actual
              //  System.exit(0);esto cierra la activity actual
                Carteles.CartelSalir( getActivity());
            }
        });



        return root;



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}