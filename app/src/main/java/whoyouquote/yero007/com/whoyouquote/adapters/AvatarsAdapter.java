package whoyouquote.yero007.com.whoyouquote.adapters;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import whoyouquote.yero007.com.whoyouquote.R;
import whoyouquote.yero007.com.whoyouquote.data.Avatar;

/**
 * Created by sabau on 10-Sep-16.
 */

public class AvatarsAdapter extends RecyclerView.Adapter<AvatarsAdapter.AvatarsViewHolder> {


    private ArrayList<Avatar> avatarsList;
    private OnAvatarClickedListener mListener;
    public AvatarsAdapter(ArrayList<Avatar> avatarsList, OnAvatarClickedListener onAvatarClickedListener) {
        this.avatarsList = avatarsList;
        mListener = onAvatarClickedListener;
    }

    @Override
    public AvatarsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_avatars, parent, false);
        AvatarsViewHolder avatarsViewHolder = new AvatarsViewHolder(v);
        return avatarsViewHolder;
    }

    @Override
    public void onBindViewHolder(final AvatarsViewHolder holder, int position) {
        holder.avatar.setImageResource(avatarsList.get(position).getDrawableId());
        final int realPosition = holder.getAdapterPosition();
        holder.avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onAvatarClicked(realPosition, avatarsList.get(realPosition).getDrawableId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return avatarsList.size();
    }

    public static class AvatarsViewHolder extends RecyclerView.ViewHolder {

        protected ImageView avatar;

        AvatarsViewHolder(View itemView) {
            super(itemView);
            avatar = (ImageView) itemView.findViewById(R.id.iv_cell_avatar);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public interface OnAvatarClickedListener {
        void onAvatarClicked(int position, int avatarResourceId);
    }

}
