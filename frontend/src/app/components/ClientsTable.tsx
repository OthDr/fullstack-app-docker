interface Client {
  nom: string;
  prenom: string;
  email: string;
}

interface Props {
  clients: Client[];
}

export default function ClientsTable({ clients }: Props) {
  return (
    <div className="overflow-x-auto mt-4">
      <table className="w-full table-auto text-left shadow-lg rounded-lg overflow-hidden border-gray-200 dark:border-gray-700 dark:bg-gray-800">
        <thead className="bg-gray-200 text-gray-700">
          <tr>
            <th className="px-4 py-3 border-r border-white dark:border-slate-700">Nom</th>
            <th className="px-4 py-3 border-r border-white dark:border-slate-700">Prénom</th>
            <th className="px-4 py-3  dark:border-slate-700">Email</th>
          </tr>
        </thead>
        <tbody className="bg-white dark:bg-slate-950 text-gray-800 dark:text-gray-200">
          {clients.map((client, idx) => (
            <tr key={idx} className="hover:bg-gray-50 border-t  dark:hover:bg-gray-700">
              <td className="px-4 py-2 border">{client.nom}</td>
              <td className="px-4 py-2 border">{client.prenom}</td>
              <td className="px-4 py-2 border">{client.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
