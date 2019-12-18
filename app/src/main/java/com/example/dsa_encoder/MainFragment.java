package com.example.dsa_encoder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.math.BigInteger;

public class MainFragment extends Fragment {
    private EditText mEditTextLengthKey;
    private Button mButtonApply;
    private EditText mEditTextEncry;
    private Button mButtonEncry;
    private EditText mEditTextEncryResult;
    private EditText mEditTextDecry;
    private Button mButtonDecry;
    private EditText mEditTextDecryResult;
    private EditText mEditTextRandomOne;
    private EditText mEditTextRandomTwo;
    private EditText mEditTextPrime;
    private EditText mEditTextPublicKey;
    private EditText mEditTextPrivateKey;
    EncryptDecrypt mEncryptDecrypt = new EncryptDecrypt();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);

        mEditTextLengthKey = view.findViewById(R.id.length_key);
        mButtonApply = view.findViewById(R.id.button_apply);//负责提交密钥的长度
        mEditTextEncry = view.findViewById(R.id.text_encry);
        mButtonEncry = view.findViewById(R.id.button_encry);
        mEditTextEncryResult = view.findViewById(R.id.encry_result);
        mEditTextDecry = view.findViewById(R.id.text_decry);
        mButtonDecry = view.findViewById(R.id.button_decry);
        mEditTextDecryResult = view.findViewById(R.id.decry_result);
        mEditTextRandomOne = view.findViewById(R.id.random_one);
        mEditTextRandomTwo = view.findViewById(R.id.random_two);
        mEditTextPrime = view.findViewById(R.id.prime);
        mEditTextPublicKey = view.findViewById(R.id.public_key);
        mEditTextPrivateKey = view.findViewById(R.id.private_key);

        mButtonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int length = Integer.parseInt(mEditTextLengthKey.getText().toString());
                mEncryptDecrypt.reset(length);
                mEditTextRandomOne.setText(mEncryptDecrypt.getRandomOne().toString());
                mEditTextRandomTwo.setText(mEncryptDecrypt.getRandomTwo().toString());
                mEditTextPrime.setText(mEncryptDecrypt.getPrime().toString());
                mEditTextPublicKey.setText(mEncryptDecrypt.getPublicKey().toString());
                mEditTextPrivateKey.setText(mEncryptDecrypt.getPrivateKey().toString());
            }
        });
        mButtonEncry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BigInteger numToEncry =new BigInteger(mEditTextEncry.getText().toString()) ;
                BigInteger numEncryed = mEncryptDecrypt.encrypt(numToEncry);
                mEditTextEncryResult.setText(numEncryed.toString());
            }
        });
        mButtonDecry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BigInteger numToDecry = new BigInteger(mEditTextDecry.getText().toString());
                BigInteger numDecryed = mEncryptDecrypt.decrypt(numToDecry);
                mEditTextDecryResult.setText(numDecryed.toString());
            }
        });
        return view;
    }
}
