import { useEffect, useState } from "react";
import { getPets, createPet } from "./api/petsApi";
import PetForm from "./components/PetForm.jsx";


function App() {
  const [backendStatus, setBackendStatus] = useState("Checking backend...");
  const [pets, setPets] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/health")
        .then((response) => response.text())
        .then((data) => setBackendStatus(data))
        .catch(() => setBackendStatus("Not connected"));
  }, []);

  useEffect(() => {
    getPets()
        .then((data) => setPets(data))
        .catch((error) => console.error(error));
  }, []);

  function handlePetAdded(savedPet){
        setPets([...pets, savedPet]);
  }

  return (
      <main style={{ padding: "2rem", fontFamily: "Arial, sans-serif" }}>
            <div style={{position: 'absolute', top: '0px', left: '5px'}}>
              <h2 style={{fontSize: '22px', margin: '0'}}>Backend Status</h2>
              <p>{backendStatus}</p>
            </div>

            <div style={{ display: 'flex', flexDirection: 'column', gap: '20px'}}>
              <h1 style={{margin: '0'}}>PAWS</h1>
              <p>Pet Activity & Wellness System</p>
            </div>

            <PetForm onPetAdded={handlePetAdded} />

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