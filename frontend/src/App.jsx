import { useEffect, useState } from "react";
import { getPets, createPet } from "./api/petsApi";


function App() {
  const [backendStatus, setBackendStatus] = useState("Checking backend...");
  const [pets, setPets] = useState([]);
  const [newPet, setNewPet] = useState({
      name: "",
      species: "",
      breed: "",
      age: "",
      weight: ""
  })

  useEffect(() => {
    fetch("http://localhost:8080/api/health")
        .then((response) => response.text())
        .then((data) => setBackendStatus(data))
        .catch(() => setBackendStatus("Could not connect to backend"));
  }, []);

  useEffect(() => {
    getPets()
        .then((data) => setPets(data))
        .catch((error) => console.error(error));
  }, []);

    function handleChange(event) {
        const { name, value } = event.target;

        setNewPet({
            ...newPet,
            [name]: value
        });
    }

    function handleSubmit(event) {
        event.preventDefault();

        createPet(newPet)
            .then((savedPet) => {
                setPets([...pets, savedPet]);
                setNewPet({
                    name: "",
                    species: "",
                    breed: "",
                    age: "",
                    weight: ""
                });
            })
            .catch((error) => console.error(error));
    }

  return (
      <main style={{ padding: "2rem", fontFamily: "Arial, sans-serif" }}>
        <h1>PAWS</h1>
        <p>Pet Activity & Wellness System</p>
        <h2>Backend Status</h2>
        <p>{backendStatus}</p>

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

          {pets.map((pet) => (
              <div key={pet.id}>
                  <h2>{pet.name}</h2>
                  <p>{pet.species}</p>
              </div>
          ))}
      </main>
  );
}

export default App;