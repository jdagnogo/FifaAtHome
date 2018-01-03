package com.example.jdagnogo.fifaatome.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.models.entities.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    ArrayList<User> users;

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_adapter, parent, false);
        return new UserAdapter.UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.getTitle().setText(users.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;

        public UserViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.pseudo);
        }

        public TextView getTitle() {
            return title;
        }
    }
}
