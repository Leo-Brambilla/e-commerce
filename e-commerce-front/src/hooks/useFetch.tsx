import axios from "axios";
import { useEffect, useState } from "react";

export function useFetch<T = unknown>(url: string){
    const [data, setData] = useState<T | null>(null)
    const [error, setError] = useState<any | null>(null)
  
    useEffect(() => {
        async function fetchData() {
            try {
                const response = await axios.get(url);
                setData(response.data);
                console.log(data)
            } catch (error) {
                setError(error);
            }
        }

        fetchData();
    }, [url])
  
    return { data, error }
}
