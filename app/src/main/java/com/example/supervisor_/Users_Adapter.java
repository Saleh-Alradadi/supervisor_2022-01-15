package com.example.supervisor_;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Users_Adapter extends RecyclerView.Adapter<Users_Adapter.userViewHolder> {
    private List<UsersDB> mUserList = new ArrayList<>();

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list_item,parent,false);
        return new userViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {
        UsersDB currentUsers = mUserList.get(position);
        holder.textViewNameList.setText(currentUsers.getNamedb());
        holder.textViewUserList.setText(currentUsers.getUserdb());
        holder.textViewDayOffList.setText(currentUsers.getDayOffdb());

    }

    public void setUsers(List<UsersDB> users){
        mUserList = users;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public static class userViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewNameList;
        public TextView textViewUserList;
        public TextView textViewDayOffList;

        public userViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNameList = itemView.findViewById(R.id.Name_Text_viewList);
            textViewUserList = itemView.findViewById(R.id.User_Text_viewList);
            textViewDayOffList = itemView.findViewById(R.id.DayOff_Text_viewList);
        }
    }
}
