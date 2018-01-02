package com.example.abhilashayadav.firebasebasics.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.abhilashayadav.firebasebasics.Activities.MainActivity;
import com.example.abhilashayadav.firebasebasics.R;




public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

 //   MainActivity homeActivity;
    RecyclerView.ViewHolder messageAdapter;
    private ItemClickListener itemClickListener;

    public MessageAdapter(MainActivity homeActivity, RecyclerView.ViewHolder messageAdapter, ItemClickListener itemClickListener) {
       // this.homeActivity = homeActivity;
        this.itemClickListener = itemClickListener;
        this.messageAdapter = messageAdapter;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main2, parent, false);
     //   MessageAdapter addressSuggestionAdapterViewHolder = new MessageAdapter(view);
        return messageAdapter;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        //MessageAdapter viewHolder = (MessageAdapter) holder;
       // viewHolder.tv_suggestion.setText(autoCompleteAddress.getPredictions().get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return 0; //autoCompleteAddress.getPredictions().size();
    }

    private class AddressSuggestionAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tv_suggestion;

        public AddressSuggestionAdapterViewHolder(View itemView) {
            super(itemView);
            tv_suggestion = itemView.findViewById(R.id.tv_name_suggestion);
            tv_suggestion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // itemClickListener.setData(autoCompleteAddress.getPredictions().get(getAdapterPosition()).getDescription());
                }
            });
        }
    }

    public interface ItemClickListener {

        void setData(String address);
    }
}



