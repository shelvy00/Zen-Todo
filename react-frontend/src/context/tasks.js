import { createContext, useState } from "react";
import axios from "axios";

const TasksContext = createContext();

function Provider({ children }) {
    const [tasks, setTasks] = useState([]);

    const fetchTasks = async () => {
        const response = await axios.get("http://localhost:8080/api/task");

        setTasks(response.data);
    };

    const editTaskById = async (id, name, description, startDate, dueDate) => {

        const response = await axios.put(`http://localhost:8080/api/task + ${id}`, {
            name: name,
            description: description,
            startDate: startDate,
            dueDate: dueDate
        });

        const updatedTasks = tasks.map((task) => {
            if(task.id === id) {
                return { ...task, ...response.data }
            };

            return task
        });
        setTasks(updatedTasks);
    };

    const deleteTaskById = async (id) => {

        await axios.delete(`http://localhost:8080/api/task + ${id}`);

        const updatedTasks = tasks.filter((task) => {
            return task.id !== id;
        });

        setTasks(updatedTasks);
    };

    const createTask = async (id, name, description, startDate, dueDate) => {
        const response = await axios.post("http://localhost:8080/api/task", {
            name: name,
            description: description,
            startDate: startDate,
            dueDate: dueDate
        });
        
        const updatedTasks = [
            ...tasks, 
          response.data
        ];
        setTasks(updatedTasks);
    };

    const valueToShare = {
        tasks: tasks,
        deleteTaskById: deleteTaskById,
        editTaskById: editTaskById,
        createTask: createTask,
        fetchTasks: fetchTasks
    };

    return <BooksContext.Provider value={valueToShare}>
        {children}
    </BooksContext.Provider>
}

export { Provider }
export default TasksContext;