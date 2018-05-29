package com.mythicaljourneyman.memoria.views.activities;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;

import com.mythicaljourneyman.memoria.R;
import com.mythicaljourneyman.memoria.preferences.AppPreferences;
import com.mythicaljourneyman.memoria.databinding.ActivityEditNamesBinding;

public class EditNamesActivity extends AppCompatActivity {
    ActivityEditNamesBinding mBinding;
    private boolean shouldSave = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_edit_names);
        mBinding.playerName.setText(AppPreferences.getPlayer1Name(this));

        mBinding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shouldSave = false;
                finish();
            }
        });
        mBinding.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shouldSave = true;
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (shouldSave) {
            Editable editable1 = mBinding.playerName.getEditableText();
            if (editable1 != null) {
                String name1 = editable1.toString().trim();
                if (!TextUtils.isEmpty(name1)) {
                    AppPreferences.setPlayer1Name(this, name1);

                }
            }

        }
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, EditNamesActivity.class);
        return intent;

    }
}
