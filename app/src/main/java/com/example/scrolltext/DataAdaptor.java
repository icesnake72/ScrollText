package com.example.scrolltext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class DataAdaptor extends RecyclerView.Adapter<DataAdaptor.ViewHolder> {

    List<Product> liProds;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textTitle;
        private final TextView textDesc;
        private final TextView textPrice;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            imageView = (ImageView)view.findViewById(R.id.image_data);
            textTitle = (TextView)view.findViewById(R.id.title_data);
            textDesc = (TextView)view.findViewById(R.id.desc_data);
            textPrice = (TextView)view.findViewById(R.id.price_data);

        }

        public TextView getTextTitle() {
            return textTitle;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextDesc() {
            return textDesc;
        }

        public TextView getTextPrice() {
            return textPrice;
        }
    }

    public DataAdaptor(List<Product> dataSet) {
        this.liProds = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_data_list, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getImageView().setImageResource(liProds.get(position).getImage());
        viewHolder.getTextTitle().setText(liProds.get(position).getTitle());
        viewHolder.getTextDesc().setText(liProds.get(position).getDesc());
        viewHolder.getTextPrice().setText(liProds.get(position).getPrice());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return liProds.size();
    }
}
