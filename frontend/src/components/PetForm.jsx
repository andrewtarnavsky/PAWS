import {createPet} from "../api/petsApi.js";
import {useState} from "react";

function PetForm({onPetAdded}){
    const [newPet, setNewPet] = useState({
        name: "",
        species: "",
        breed: "",
        age: "",
        weight: ""
    });

    function handleChange(event) {
        const { name, value } = event.target;

        setNewPet( {...newPet, [name]: value} );
    }

    function handleSubmit(event) {
        event.preventDefault();
        if (newPet.name.trim().length === 0){
            alert("Pet Name is missing!");
            return;
        }

        if (newPet.species.trim().length === 0){
            alert("Pet Species is missing!");
            return;
        }

        createPet(newPet)
            .then((savedPet) => {
                // Notify the parent component to update the pets array
                onPetAdded(savedPet);
                // Clear the form
                setNewPet({ name: "", species: "", breed: "", age: "", weight: "" });
            })
            .catch((error) => console.error(error));
    }

    return (
        <form className= "pet-form" onSubmit={handleSubmit}>
            <h2 className="pet-form-title">Register New Pet</h2>
            <div className="pet-form-group">
                <label className="pet-form-label">Pet Name*</label>
                <input
                    name="name"
                    placeholder="Enter Pet Name"
                    value={newPet.name}
                    onChange={handleChange}
                />
            </div>

            <div className="pet-form-group">
                <label className="pet-form-label">Pet Species*</label>
                <input
                    name="species"
                    placeholder="Enter Species"
                    value={newPet.species}
                    onChange={handleChange}
                />
            </div>

            <div className="pet-form-group">
                <label className="pet-form-label">Pet Breed</label>
                <input
                    name="breed"
                    placeholder="Enter Breed"
                    value={newPet.breed}
                    onChange={handleChange}
                />
            </div>


            <div className="pet-form-group">
                <label className="pet-form-label">Pet Age</label>
                <input
                    name="age"
                    placeholder="Enter Age"
                    value={newPet.age}
                    onChange={handleChange}
                />
            </div>


            <div className="pet-form-group">
                <label className="pet-form-label">Pet Weight</label>
                <input
                    name="weight"
                    placeholder="Enter Weight"
                    value={newPet.weight}
                    onChange={handleChange}
                />
            </div>

            <button className="pet-form-submit-btn" type="submit" style={{margin: 'auto'}}>Add Pet</button>
        </form>
    );
}

export default PetForm;
