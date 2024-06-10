package com.example.composedemo24

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import java.time.Instant

class TodoViewModel : ViewModel() {

    val todoDao = MainApplication.todoDatabase.getTodoDao()

    //private var _todoList = MutableLiveData<List<Todo>>()
    //val todoList : LiveData<List<Todo>> = _todoList

    val todoList : LiveData<List<Todo>> = todoDao.getAllTodo()

    fun getAllTodo() {
        //_todoList.value = TodoRepo.getAllTodo().reversed()
    }

    fun addTodo(title : String){
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.addTodo(Todo(title = title, date = Date.from(Instant.now())))
        }
        //TodoRepo.addTodo(title)
        //getAllTodo()
    }

    fun deleteTodo(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(id)
        }
        //TodoRepo.deleteTodo(id)
        //getAllTodo()
    }

}