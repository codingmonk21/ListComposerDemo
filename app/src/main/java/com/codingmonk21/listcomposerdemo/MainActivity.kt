package com.codingmonk21.listcomposerdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingmonk21.listcomposerdemo.adapters.*
import com.codingmonk21.listcomposerdemo.listcomposer.AdapterItem
import com.codingmonk21.listcomposerdemo.listcomposer.FallbackConfig
import com.codingmonk21.listcomposerdemo.listcomposer.ListComposer
import com.codingmonk21.listcomposerdemo.models.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvItems = findViewById<RecyclerView>(R.id.rvItems)
        rvItems.layoutManager = LinearLayoutManager(this)

        val fallbackConfig = FallbackConfig(Fallback("Fallback"), FallbackAdapter())

        val adapter =
            ListComposer.Builder(fallbackConfig)
                .add(RedAdapter { model, id ->
                    showToast(model.name)
                })
                .add(BlueAdapter { model, id ->
                    showToast(model.name)
                })
                .add(GreenAdapter { model, id ->
                    showToast(model.name)
                })
                .add(YellowAdapter { model, id ->
                    showToast(model.name)
                })
                .add(PurpleAdapter { model, id ->
                    showToast(model.name)
                })
                .add(OrangeListAdapter({ model, id ->
                }, { model: AdapterItem, id: Int ->
                    when (model) {
                        is Orange -> showToast(model.name)
                        is Green -> showToast(model.name)
                    }
                }))
                .build()

        adapter.setData(getDummyData())
        rvItems.adapter = adapter
    }

    private fun showToast(color: String) {
        Toast.makeText(this, "$color clicked", Toast.LENGTH_SHORT).show()
    }

    private fun getDummyData(): MutableList<AdapterItem> {
        val list = mutableListOf<AdapterItem>()

        val red1 = Red("Red 1")
        val red2 = Red("Red 2")
        val red3 = Red("Red 3")

        val blue1 = Blue("Blue 1")
        val blue2 = Blue("Blue 2")
        val blue3 = Blue("Blue 3")

        val green1 = Green("Green 1")
        val green2 = Green("Green 2")
        val green3 = Green("Green 3")

        val yellow1 = Yellow("Yellow 1")
        val yellow2 = Yellow("Yellow 2")
        val yellow3 = Yellow("Yellow 3")

        val purple1 = Purple("Purple 1")
        val purple2 = Purple("Purple 2")
        val purple3 = Purple("Purple 3")

        val orange1 = Orange("Orange 1")
        val orange2 = Orange("Orange 2")
        val orange3 = Orange("Orange 3")
        val orange4 = Orange("Orange 4")
        val orange5 = Orange("Orange 5")

        val unknown = Unknown("Unknown")

        val orangeModels = listOf(orange1, unknown, green1, orange2, orange3, orange4, orange5)

        val orangeList1 = OrangeList(orangeModels)
        val orangeList2 = OrangeList(orangeModels)

        list.add(red1)
        list.add(red2)
        list.add(red3)

        list.add(blue1)
        list.add(blue2)
        list.add(blue3)

        list.add(orangeList1)
        list.add(orangeList2)

        list.add(green1)
        list.add(green2)
        list.add(green3)

        list.add(yellow1)
        list.add(yellow2)
        list.add(yellow3)

        list.add(purple1)
        list.add(purple2)
        list.add(purple3)

        list.add(unknown)

        list.shuffle()
        return list
    }
}