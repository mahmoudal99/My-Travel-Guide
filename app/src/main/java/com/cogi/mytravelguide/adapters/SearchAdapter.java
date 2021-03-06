package com.cogi.mytravelguide.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.cogi.mytravelguide.R;
import com.cogi.mytravelguide.models.LandmarkModel;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> implements Filterable {
    private List<LandmarkModel> contactList;
    private List<LandmarkModel> contactListFiltered;
    private LandmarkAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.place_name);

            view.setOnClickListener(view1 -> {
                listener.onLandmarkSelected(contactListFiltered.get(getAdapterPosition()));
            });
        }
    }


    public SearchAdapter(List<LandmarkModel> contactList, LandmarkAdapterListener listener) {
        this.listener = listener;
        this.contactList = contactList;
        this.contactListFiltered = contactList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.near_by_location_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final LandmarkModel attractionObject = contactListFiltered.get(position);
        holder.name.setText(attractionObject.getPlaceName());
    }

    @Override
    public int getItemCount() {
        return contactListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    contactListFiltered = contactList;
                } else {
                    List<LandmarkModel> filteredList = new ArrayList<>();
                    for (LandmarkModel row : contactList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getPlaceName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    contactListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = contactListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                contactListFiltered = (ArrayList<LandmarkModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface LandmarkAdapterListener {
        void onLandmarkSelected(LandmarkModel contact);
    }
}
