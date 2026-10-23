const BASE_URL = "http://localhost:8080/api";

export async function getLogs(petId) {
    const response = await fetch(`${BASE_URL}/pets/${petId}/logs`);

    if (!response.ok) {
        throw new Error(`Failed to fetch logs for pet ${petId}: ${response.statusText}`);
    }

    return await response.json();
}

export async function createLog(petId, logEntry){
    const response = await fetch(`${BASE_URL}/pets/${petId}/logs`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(logEntry),
        });

    if(!response.ok){
        throw new Error(`Failed to create log for pet ${petId} (Status: ${response.status} ${response.statusText})`)
    }

    return await response.json();
}
