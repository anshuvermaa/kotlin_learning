import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.todolist.database.Task
import com.example.todolist.database.TaskDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var taskListViewModel: TaskListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskDao = TaskDatabase.getInstance(application).taskDao()
        taskListViewModel = ViewModelProviders.of(this).get(TaskListViewModel::class.java)

        taskListViewModel.tasks.observe(this, Observer { tasks ->
            // update the UI with the list of tasks
        })

        addTaskButton.setOnClickListener {
            // add a new task to the database and update the UI
            val task = Task(taskNameEditText.text.toString())
            taskListViewModel.addTask(task)
        }
    }
}
