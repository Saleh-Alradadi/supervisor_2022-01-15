package com.example.supervisor_;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Loactions_Adapter extends RecyclerView.Adapter<Loactions_Adapter.luoactionsViewHolder> {

    private static List<LocationsDB> mLocationList = new ArrayList<>();
    private static Loactions_Adapter.OnItemclickListner mListner;

    @NonNull
    @Override
    public luoactionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.loactions_list_view,parent,false);
        return new Loactions_Adapter.luoactionsViewHolder(itemView);
    }

    public void setUsers(List<LocationsDB> locations){
        mLocationList = locations;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull luoactionsViewHolder holder, int position) {
        LocationsDB currentUsers = mLocationList.get(position);
        holder.textLocationList.setText(currentUsers.getNameLocation());
        holder.textClassificationViewList.setText(currentUsers.getClassification());
    }

    @Override
    public int getItemCount() {
        return mLocationList.size();
    }

    public static class luoactionsViewHolder extends RecyclerView.ViewHolder {
        public TextView textLocationList;
        public TextView textClassificationViewList;

        public luoactionsViewHolder(@NonNull View itemView) {
            super(itemView);
            textLocationList = itemView.findViewById(R.id.Location_viewList);
            textClassificationViewList = itemView.findViewById(R.id.Classification_viewList);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();
                    if (mListner != null && index != RecyclerView.NO_POSITION){
                        mListner.onItemClick(mLocationList.get(index));
                    }
                }
            });
        }
    }
    public interface OnItemclickListner{
        void onItemClick(LocationsDB locationsDB);
    }

    public void onItemClickListner(Loactions_Adapter.OnItemclickListner listner){
        mListner = listner;
    }

    public LocationsDB getLocationsAt(int pos){
        return mLocationList.get(pos);
    }
}
