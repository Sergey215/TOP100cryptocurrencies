package android.exemple.myfirstapp.chart

import android.annotation.SuppressLint
import android.content.Context
import android.exemple.myfirstapp.R
import android.exemple.myfirstapp.extensions.dateToString
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.utils.MPPointF

@SuppressLint("ViewConstructor")
class MyMarkerView (context: Context, layoutResource: Int) : MarkerView(context, layoutResource) {

    private val tvContent: TextView

    init {
        tvContent = findViewById(R.id.tvContent)
    }
    override fun refreshContent(e: Entry, highlight: Highlight){
        tvContent.text = e.y.toString() + "\n" + e.x.dateToString("MMM dd, yyyy")
        super.refreshContent(e, highlight)
    }
    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-height).toFloat())
    }
}