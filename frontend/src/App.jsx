import { useEffect, useState } from "react";
import { getPets} from "./api/petsApi";
import PetForm from "./components/PetForm.jsx";
//import PetCard from "./components/PetCard.jsx";
import PetList from "./components/PetList.jsx";

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
            <div style={{position: 'absolute', top: '0px', left: '0px', fontSize: '13px', margin: '0 auto', lineHeight: '1', width: '150px'}}>
              <p style={{margin: '0'}}>Backend Status</p>
              <p style={{margin: 0, padding: 0}}>{backendStatus}</p>
            </div>

            <div style={{ display: 'flex', flexDirection: 'column', gap: '20px'}}>
              <h1 style={{margin: '0'}}>PAWS</h1>
              <p>Pet Activity & Wellness System</p>
            </div>

            <PetList pets = {pets}/>
            <PetForm onPetAdded={handlePetAdded} />

      </main>
  );
}

export default App;