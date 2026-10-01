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
        <form onSubmit={handleSubmit}>
            <input
                name="name"
                placeholder="Pet name"
                value={newPet.name}
                onChange={handleChange}
            />

            <input
                name="species"
                placeholder="Species"
                value={newPet.species}
                onChange={handleChange}
            />

            <input
                name="breed"
                placeholder="Breed"
                value={newPet.breed}
                onChange={handleChange}
            />

            <input
                name="age"
                placeholder="Age"
                value={newPet.age}
                onChange={handleChange}
            />

            <input
                name="weight"
                placeholder="Weight"
                value={newPet.weight}
                onChange={handleChange}
            />

            <button type="submit">Add Pet</button>
        </form>
    );
}

export default PetForm;
