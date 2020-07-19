package com.example.androidfunctionality.mains;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidfunctionality.R;
import com.example.androidfunctionality.dodge_inset_edge.DodgeInsetEdgeActivity;
import com.example.androidfunctionality.firstlaunch.ExecuteCodeOnFirstLaunchActivity;
import com.example.androidfunctionality.menu.OptionMenuActivity;
import com.example.androidfunctionality.menu.PopUpMenuActivity;
import com.example.androidfunctionality.parcelable.ParcelableActivity;
import com.example.androidfunctionality.random_text_view.RandomTextViewActivity;
import com.example.androidfunctionality.searchview.SearchViewActivity;
import com.example.androidfunctionality.sharedpreference.SharedPreferenceActivity;
import com.example.androidfunctionality.start_activity_for_result.StartActivityForResultActivity;
import com.example.androidfunctionality.toasty.ToastyActivity;
import com.example.androidfunctionality.up_backbutton.BackButtonActivity;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<MainsData> dataList;
    private Context context;

    Adapter(List<MainsData> list, Context context) {
        this.dataList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mains_data,
            parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final MainsData data = dataList.get(position);
        holder.tvMainsData.setText(data.getTitle());

        holder.tvMainsData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;

                switch (data.getType()){

                    case FIRST:
                        intent = new Intent(context, SearchViewActivity.class);
                        context.startActivity(intent);
                        break;

                    case SECOND:
                        intent = new Intent(context, ToastyActivity.class);
                        context.startActivity(intent);
                        break;

                    case THIRD:
                        intent = new Intent(context, SharedPreferenceActivity.class);
                        context.startActivity(intent);
                        break;

                    case FOURTH:
                        intent = new Intent(context, DodgeInsetEdgeActivity.class);
                        context.startActivity(intent);
                        break;

                    case FIFTH:
                        intent = new Intent(context, BackButtonActivity.class);
                        context.startActivity(intent);
                        break;

                    case SIXTH:
                        intent = new Intent(context, OptionMenuActivity.class);
                        context.startActivity(intent);
                        break;

                    case SEVENTH:
                        intent = new Intent(context, PopUpMenuActivity.class);
                        context.startActivity(intent);
                        break;

                    case EIGHT:
                        intent = new Intent(context, RandomTextViewActivity.class);
                        context.startActivity(intent);
                        break;

                    case NINE:
                        intent = new Intent(context, StartActivityForResultActivity.class);
                        context.startActivity(intent);
                        break;

                    case TEN:
                        intent = new Intent(context, ParcelableActivity.class);
                        context.startActivity(intent);
                        break;

                    case ELEVEN:
                        intent = new Intent(context, ExecuteCodeOnFirstLaunchActivity.class);
                        context.startActivity(intent);
                        break;

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvMainsData;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMainsData = itemView.findViewById(R.id.tvMainsData);
        }
    }
}
