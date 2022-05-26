package ir.almasapps.recyclerviewwithswipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = UserAdapter(this,DataService.users)


        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter


        val swipeGesture = object :SwipeGesture(this){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when(direction){
                    ItemTouchHelper.LEFT -> {

                        DataService.users.removeAt(viewHolder.absoluteAdapterPosition)
                        adapter.notifyItemRemoved(viewHolder.absoluteAdapterPosition)

                    }
                    ItemTouchHelper.RIGHT -> {

                        DataService.users.removeAt(viewHolder.absoluteAdapterPosition)
                        adapter.notifyItemRemoved(viewHolder.absoluteAdapterPosition)

                    }

                }


            }
        }

        val touchHelper = ItemTouchHelper(swipeGesture)
        touchHelper.attachToRecyclerView(recyclerview)

    }
}