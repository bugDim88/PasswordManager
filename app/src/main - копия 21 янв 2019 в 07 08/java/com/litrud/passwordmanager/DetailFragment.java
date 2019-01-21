package com.litrud.passwordmanager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;


public class DetailFragment extends Fragment {
    private long accountId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override   // вызывается перед тем, как фрагмент становися видимым
    public void onStart() {
        super.onStart();
        final View view = getView(); // gets the root View object of the fragment
        if (view != null)
        {
            Account account = Account.accounts[(int) accountId];

            EditText comments = (EditText) view.findViewById(R.id.comments);
            comments.setText(account.getComments());
            EditText title = (EditText) view.findViewById(R.id.title);
            title.setText(account.getTitle());
            EditText username = (EditText) view.findViewById(R.id.username);
            username.setText(account.getUsername());
            EditText website = (EditText) view.findViewById(R.id.website);
            website.setText(account.getWebsite());
            EditText login = (EditText) view.findViewById(R.id.login);
            login.setText(account.getLogin());
            EditText password = (EditText) view.findViewById(R.id.password);
            password.setText(account.getPassword());

            ImageView imageView = (ImageView) view.findViewById(R.id.iconID);
            imageView.setImageDrawable(getResources().getDrawable(account.getIconID()));
            imageView.setContentDescription(account.getTitle());

            // прокрутиться в самый низ
            final ScrollView scrollView = (ScrollView) view.findViewById(R.id.scroll_view);
            if (scrollView != null)
            scrollView.getViewTreeObserver().addOnGlobalLayoutListener(
                    new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            scrollView.post(new Runnable() {
                                @Override
                                public void run() {
                                    scrollView.fullScroll(View.FOCUS_DOWN);
                                }
                            });
                        }
                    });
            else
                System.out.println("FUCK!.."); // FFFUUUUCCCCKKK !!!!!!!
        }
    }


    public void setAccountId(long id) {
        this.accountId = id;
    }
}
