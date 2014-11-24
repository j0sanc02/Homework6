package com.example.jpapp_000.homework6;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;

/**
 * Created by jpapp_000 on 11/23/2014.
 */
public class AddColorFragment extends Fragment implements View.OnClickListener {

    Context mcontext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.addfragment,container,false);
        Button button = (Button)rootView.findViewById(R.id.AddButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = (EditText) rootView.findViewById(R.id.editText);
                String text = editText.getText().toString();
                ParseObject testObject = new ParseObject("ColorClass");
                testObject.put("Color", text);
                testObject.saveInBackground();
                editText.setText("");
                Toast.makeText(getActivity().getApplicationContext(), R.string.color,Toast.LENGTH_SHORT);

                //InputMethodManager imm = (InputMethodManager)mcontext.getSystemService(Context.INPUT_METHOD_SERVICE);
                //imm.hideSoftInputFromWindow(editText.getWindowToken(),0);
            }
        });

        return rootView;

    }


    @Override
    public void onClick(View v) {

    }
}
