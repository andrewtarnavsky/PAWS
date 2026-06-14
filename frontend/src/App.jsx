import { useEffect, useState } from "react";
import { getPets, createPet } from "./api/petsApi";

function App() {
  const [backendStatus, setBackendStatus] = useState("Checking backend...");
  const [pets, setPets] = useState([]);

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

  return (
      <main style={{ padding: "2rem", fontFamily: "Arial, sans-serif" }}>
        <h1>PAWS</h1>
        <p>Pet Activity & Wellness System</p>
        <h2>Backend Status</h2>
        <p>{backendStatus}</p>
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