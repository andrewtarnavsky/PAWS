import { useEffect, useState } from "react";

function App() {
  const [backendStatus, setBackendStatus] = useState("Checking backend...");

  useEffect(() => {
    fetch("http://localhost:8080/api/health")
        .then((response) => response.text())
        .then((data) => setBackendStatus(data))
        .catch(() => setBackendStatus("Could not connect to backend"));
  }, []);

  return (
      <main style={{ padding: "2rem", fontFamily: "Arial, sans-serif" }}>
        <h1>PAWS</h1>
        <p>Pet Activity & Wellness System</p>

        <h2>Backend Status</h2>
        <p>{backendStatus}</p>
      </main>
  );
}

export default App;