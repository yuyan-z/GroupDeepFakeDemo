package com.example.demo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private TextView textViewAddPrompt;
    private ConstraintLayout layoutNewFriend;
    private List<User> users = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_message, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewMessage);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        users = new ArrayList<>();
        users.add(new User("Father", "data:image/jpeg;base64,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"));
        users.add(new User("Mother", "https://buffer.com/cdn-cgi/image/w=1000,fit=contain,q=90,f=auto/library/content/images/size/w1200/2023/10/free-images.jpg"));

        MessageAdapter adapter = new MessageAdapter(getContext(), users);
        recyclerView.setAdapter(adapter);
    }

    public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
        private List<User> users;
        private Context context;

        public MessageAdapter(Context context, List<User> users) {
            this.users = users;
            this.context = context;
        }

        @NonNull
        @Override
        public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
            return new MessageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
            User user = users.get(position);
            holder.textViewName.setText(user.getUsername());
            Glide.with(context)
                    .load(user.getAvatar())
                    .error(R.drawable.load_error) // 加载失败的错误图
                    .into(holder.imageViewAvatar);;
        }

        @Override
        public int getItemCount() {
            return users.size();
        }

        class MessageViewHolder extends RecyclerView.ViewHolder {
            ImageView imageViewAvatar;
            TextView textViewName;
            public MessageViewHolder(@NonNull View itemView) {
                super(itemView);
                imageViewAvatar = itemView.findViewById(R.id.imageViewContact);
                textViewName = itemView.findViewById(R.id.textViewContact);
            }
        }
    }




}
