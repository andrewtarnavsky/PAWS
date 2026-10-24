import {useState} from "react";

function LogForm({onLogAdded}){
    const [newLog, setNewLog] = useState({
            mood: "",
            energy: "",
            appetite: "",
            symptoms: "",
        }
    );

    function handleChange(event){

    }

    function handleSubmit(event){

    }

    return(
        <form className="log-form" onSubmit={onLogAdded}>

            <div className="log-form-group">
                <label className="log-form-label"> </label>
                <input

                />
            </div>

            <button className="log-form-submit-btn" type="submit">Add Log</button>
        </form>
    )
}
export default LogForm;