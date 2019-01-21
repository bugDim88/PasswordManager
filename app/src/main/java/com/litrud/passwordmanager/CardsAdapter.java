package com.litrud.passwordmanager;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.ViewHolder> {

    private int[] iconsIDs;
    private String[] titles;
    private Listener listener;

    public static interface Listener {
        public void onClick(int position);
    }

    // предоставляет ссылку на представления, используемые в RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) { // в RecyclerView мы используем данные типа CardView
            super(v);
            cardView = v;
        }
    }

    // передать данные адаптеру в конструторе
    public CardsAdapter(int[] iconsIDs, String[] titles) {
        this.iconsIDs = iconsIDs;
        this.titles = titles;
    }

    // создание ViewHolder
    @NonNull
    @Override
    public CardsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false); // макет для ViewHolder
        return new ViewHolder(cv);
    }

    // добавление данных в карточки
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;

        ImageView imageView = (ImageView)cardView.findViewById(R.id.iconID);
        Drawable drawable = cardView.getResources().getDrawable(iconsIDs[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(titles[position]);

        TextView textView1 = (TextView)cardView.findViewById(R.id.text1);
        textView1.setText(titles[position]);

        TextView textView2 = (TextView)cardView.findViewById(R.id.text2);
        textView2.setText("test text2");


        // при щелчке на CardView вызвать метод onClick() интерфейса Listener
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    // активности и/или фрагменты используют этот метод для регистрации себя в качестве слушателя
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    // получить кол-во категорий
    @Override
    public int getItemCount() {
        return titles.length;
    }
}
