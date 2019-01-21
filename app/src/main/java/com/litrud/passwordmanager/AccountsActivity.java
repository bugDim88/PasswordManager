package com.litrud.passwordmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AccountsActivity extends AppCompatActivity {
    public static final String EXTRA_CATEGORYNO = "categoryNo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        // получить данные из интента
        int categoryNo = (Integer) getIntent().getExtras().get(EXTRA_CATEGORYNO);

        AccountsFragment accountsFrag = (AccountsFragment)
                    getSupportFragmentManager().findFragmentById(R.id.accounts_frag);
        accountsFrag.setCategoryId(categoryNo);

        DetailFragment detailFrag = (DetailFragment)
                    getSupportFragmentManager().findFragmentById(R.id.detail_frag); // page 313
        detailFrag.setAccountId(1); // произвольный выбор, 1

    }
}
