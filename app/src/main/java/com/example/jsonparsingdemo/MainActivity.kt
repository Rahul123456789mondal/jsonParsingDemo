package com.example.jsonparsingdemo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    private val TAG = "MyActivity"
    private val JSON_STRING : String = "{\"Arka\":{\"id\":\"1\",\"2name\":\"Mondal\",\"address\":{\"village\":\"Palla Road\"}}}"
    var aDDress : String = ""
    var salary : String = ""

    private lateinit var employeeName : TextView
    private lateinit var employeeSalary : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get the reference of TextView's
        employeeName = findViewById(R.id.name)
        employeeSalary = findViewById(R.id.salary)

        try {
            // get JSONObject from JSON file
                var obj : JSONObject = JSONObject(JSON_STRING) // in this line read the json from the string
                val jasonData = JSONObject(loadJSONFromAsset())
            // fetch JSONObject name employee
                val arka : JSONObject = obj.getJSONObject("Arka")
                val address : JSONObject = arka.getJSONObject("address")

                val subassemblies : JSONObject = jasonData.getJSONObject("subassemblies")
                val componentAnalyzer1 : JSONObject = subassemblies.getJSONObject("componentAnalyzer1")
                val collectors : JSONObject = componentAnalyzer1.getJSONObject("collectors")
                val bp1 : JSONObject = collectors.getJSONObject("bp1")
                val CSV  = bp1.getJSONArray("CSV")
            // implement for loop for getting JSON data
                for (i in 0 until CSV.length()){
                    val userDetail  = CSV.getJSONArray(i)
                    for (j in 0 until userDetail.length()){
                        val example = userDetail[j]
                        Log.d(TAG, "Data is : - "+userDetail[j])
                        employeeSalary.append(example.toString())
                    }
                }

            // get employee name and salary & In this step the data will show into the view
                aDDress = address.getString("village")
                //Log.d(TAG,"JSON DATA : -"+name)
                //salary = employee.getString("salary")
                // set emploee name and salary in TextView's
                employeeName.text = "Id : "+aDDress
                //employeeSalary.text = "Salary : "+salary

        }catch ( e: JSONException ){
            Log.d(TAG, "Error : ${e.message}")
            e.printStackTrace()
        }
    }

    private fun loadJSONFromAsset(): String{
        //function to load the JSON from the Asset and return the object
        var json: String = null.toString()
        val charset: Charset = Charsets.UTF_8

        try {
            val jsonFileLoad = assets.open("demo.json")
            val size = jsonFileLoad.available()
            val buffer = ByteArray(size)
            jsonFileLoad.read(buffer)
            jsonFileLoad.close()
            json = String(buffer, charset)
        } catch (ex : IOException){
            ex.printStackTrace()
        }
        return json
    }
}



























//Log.d(TAG,"Acess the node : -"+subassemblies)












