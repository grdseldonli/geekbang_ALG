class Solution {
public List<String> subdomainVisits(String[] cpdomains) {
	    Map<String, Integer> map= new HashMap<String, Integer>();
		for(String one:cpdomains) {

			String[] oneRecord=one.split(" ");
			int num= Integer.valueOf(oneRecord[0].toString());
			
			
			String[] oneRecordDomain=oneRecord[1].split("\\.");
			String domian="";
			for(int i=oneRecordDomain.length-1;i>=0;i--) {
				if(i==oneRecordDomain.length-1) 
					{
						domian=oneRecordDomain[i];
					}else {
						
						domian=oneRecordDomain[i]+"."+domian;
						
					}

				map.put(domian, map.getOrDefault(domian, 0)+num);
					
				}
				
				
			}
		List<String> result=new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
 
            
            result.add(entry.getValue()+" "+entry.getKey());
  
           
            
        }

		return  result;
			
			

			
		}
}