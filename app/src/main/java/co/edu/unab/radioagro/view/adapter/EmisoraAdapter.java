package co.edu.unab.radioagro.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import co.edu.unab.radioagro.model.entity.Emisora;
import co.edu.unab.radioagro.R;

public class EmisoraAdapter extends RecyclerView.Adapter<EmisoraAdapter.EmisoraViewHolder> implements View.OnClickListener {

    ArrayList<Emisora> emisoras;
    OnItemClickListener onItemClickListener;

    public EmisoraAdapter(ArrayList<Emisora> emisoras) {
        this.emisoras = emisoras;
        this.onItemClickListener = null;
    }

    public void setEmisoras(ArrayList<Emisora> emisoras) {
        this.emisoras = emisoras;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public EmisoraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emisora_item, parent, false);
        return new EmisoraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmisoraViewHolder holder, int position) {
        holder.onBind(emisoras.get(position));
    }

    @Override
    public int getItemCount() {
        return emisoras.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class EmisoraViewHolder extends RecyclerView.ViewHolder {

        ImageView ivEmisora;
        TextView tvNombre;
        TextView tvDescripcion;

        public EmisoraViewHolder(@NonNull View itemView) {
            super(itemView);

            ivEmisora = itemView.findViewById(R.id.iv_emisora);
            tvNombre = itemView.findViewById(R.id.tv_nombre);
            tvDescripcion = itemView.findViewById(R.id.tv_descripcion);

        }

        public void onBind(Emisora emisora){

            tvNombre.setText(emisora.getNombreEmisora());
            tvDescripcion.setText(emisora.getDescripcionEmisora());

            Glide.with(itemView.getContext()).load(emisora.getImagenEmisora()).into(ivEmisora);

            if (onItemClickListener!=null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(emisora, getAdapterPosition());
                    }
                });
            }
        }
    }

    public  interface OnItemClickListener {
        void onItemClick(Emisora emisora, int posicion);
    }
}
