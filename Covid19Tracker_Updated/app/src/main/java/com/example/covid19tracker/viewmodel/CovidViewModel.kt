package com.example.covid19tracker.viewmodel

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.covid19tracker.database.UserDatabase
import com.example.covid19tracker.database.Users
import com.example.covid19tracker.modelclass.CovidModel
import com.example.covid19tracker.repository.CovidRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidViewModel(private val context: Context, private val owner: LifecycleOwner):ViewModel(), Callback<CovidModel>
{
    private val repository = CovidRepository(this)

    /* private val mutableLiveData = MutableLiveData<CovidUIModel>()

    val liveData: LiveData<CovidUIModel> = mutableLiveData*/

    override fun onResponse(call: Call<CovidModel>, response: Response<CovidModel>) {
        response.body()?.let {
            CoroutineScope(Dispatchers.IO).launch {
               /* for (i in it.indices) {*/
                    val users = Users(name = it.grade, state = it.state)
                    UserDatabase.getInstance(context).userDao.insertUser(users)
                //}
            }
            /* mutableLiveData.value = CovidUIModel.Success(it)*/
        }

    }

    override fun onFailure(call: Call<CovidModel>, t: Throwable) {
        /*   mutableLiveData.value = CovidUIModel.Failure(t.message!!)*/

    }

    fun CovidcallApi() {
        UserDatabase.getInstance(context).userDao.getAllUsers().observe(owner, Observer {
            if (it.isNullOrEmpty()) {
                repository.getListofRate()
            }
            /* repository.getListofRate()*/
        })

    }
}
