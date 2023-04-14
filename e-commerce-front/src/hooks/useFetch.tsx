import axios from "axios";
import { useEffect, useState } from "react";

export function useFetch<T = unknown>(url: string){
    const [data, setData] = useState<T | null>(null)
    const [error, setError] = useState<any | null>(null)
  
    useEffect(() => {
        console.log(data)
      axios.get(url)
        .then(response => {
          setData(response.data);  
        })
        .catch(error => {
          setError(error);
        });
    }, [])
  
    return { data, error }
  }