package com.example.jdagnogo.fifaatome.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.models.entities.User;
import com.example.jdagnogo.fifaatome.utils.ImageUtils;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

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
        holder.getPseudo().setText(users.get(position).getPseudo());
        holder.getFullName().setText(users.get(position).getFullName());
        holder.getPhoto().setImageDrawable(
                ImageUtils.getProfileDrawableFromName(users.get(position).getPhoto()));
    }


    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView pseudo;
        private final CircleImageView photo;
        private final TextView fullName;

        public UserViewHolder(View itemView) {
            super(itemView);
            pseudo = (TextView) itemView.findViewById(R.id.pseudo);
            photo = (CircleImageView) itemView.findViewById(R.id.photo);
            fullName = (TextView) itemView.findViewById(R.id.fullName);
        }
        public TextView getFullName() {
            return fullName;
        }
        public TextView getPseudo() {
            return pseudo;
        }
        public CircleImageView getPhoto(){return photo;}
    }
}
